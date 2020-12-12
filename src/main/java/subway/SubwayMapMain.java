package subway;

import java.util.Scanner;

public class SubwayMapMain {
    OutputMessage outputMessage=new OutputMessage();
    private int choiceNumber=0;
    public SubwayMapMain(Scanner scanner){
        outputMessage.mainOutputMessage();
        this.choiceNumber=outputMessage.choiceOutputMessage(scanner);

    }






}
