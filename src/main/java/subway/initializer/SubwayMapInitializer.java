package subway.initializer;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import subway.dto.LineDto;
import subway.dto.SectionRegistrationDto;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SubwayMapInitializer {
    private static final String FILE_COMPOSITION_ERROR = "파일을 불러오는 과정에서 에러가 발생했습니다. 프로그램을 종료합니다.";
    private static final String DATA_INITIALIZE_ERROR = "초기 데이터에 문제가 있습니다. 프로그램을 종료합니다.";

    private final List<SampleData> sampleDatas = new ArrayList<>();
    private final StationService stationService = new StationService();
    private final LineService lineService = new LineService();
    private final SectionService sectionService = new SectionService();

    public void run() {
        Document document = makeDocument();
        try {
            NodeList lines = document.getElementsByTagName("line");
            for (int i = 0; i < lines.getLength(); ++i) {
                Node item = lines.item(i);
                sampleDatas.add(createData(item));
            }
            storeData();
        } catch (Exception e) {
            throw new RuntimeException(DATA_INITIALIZE_ERROR);
        }
    }

    private Document makeDocument() {
        Document document;
        String path = "./src/main/java/subway/initializer/";
        String fileName = "sample_data.xml";

        try {
            File file = new File(path + fileName);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
        } catch (Exception e) {
            throw new RuntimeException(FILE_COMPOSITION_ERROR);
        }
        return document;
    }

    private SampleData createData(Node lineNode) {
        SampleData sampleData = new SampleData();
        NodeList childNodes = lineNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeName().equals("name")) {
                sampleData.lineName = item.getTextContent();
            }
            if (item.getNodeName().equals("station")) {
                sampleData.stationNames.add(item.getTextContent());
            }
        }
        return sampleData;
    }

    private void storeData() {
        for (SampleData sampleData : sampleDatas) {
            String lineName = sampleData.lineName;
            List<String> stationNames = sampleData.stationNames;
            final int firstSequence = 0;
            final int lastSequence = stationNames.size() - 1;
            String upwardEndStation = stationNames.get(firstSequence);
            String downwardEndStation = stationNames.get(lastSequence);
            storeStations(stationNames);
            storeLine(lineName, upwardEndStation, downwardEndStation);
            storeSection(lineName, stationNames);
        }
    }

    private void storeStations(List<String> stationNames) {
        for (String stationName : stationNames) {
            if (stationService.isExistentName(stationName)) {
                continue;
            }
            stationService.addStationByName(stationName);
        }
    }

    private void storeLine(String lineName, String upwardEndStation, String downwardEndStation) {
        lineService.addLine(new LineDto(lineName, upwardEndStation, downwardEndStation));
    }

    private void storeSection(String lineName, List<String> stationNames) {
        final int firstSequence = 0;
        final int lastSequence = stationNames.size() - 1;
        for (int i = firstSequence + 1; i < lastSequence; i++) {
            String sequence = Integer.toString(i + 1);
            SectionRegistrationDto sectionRegistrationDto = new SectionRegistrationDto(lineName, stationNames.get(i), sequence);
            sectionService.addSection(sectionRegistrationDto);
        }
    }

    private class SampleData {
        String lineName;
        List<String> stationNames = new ArrayList<>();
    }
}
