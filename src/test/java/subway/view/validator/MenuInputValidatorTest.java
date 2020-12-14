package subway.view.validator;

import org.junit.Test;

import subway.view.MenuInputException;
import subway.view.MenuInputValidator;

public class MenuInputValidatorTest {
    @Test(expected = MenuInputException.class)
    public void testMainMenuSelection() {
        MenuInputValidator.validateMenuSelection("Main", "5");
        MenuInputValidator.validateMenuSelection("Main", " ");
        MenuInputValidator.validateMenuSelection("Main", "+~");
        MenuInputValidator.validateMenuSelection("Main", "q");
    }
    
    @Test(expected = MenuInputException.class)
    public void testStationMenuSelection() {
        MenuInputValidator.validateMenuSelection("Station", "4");
        MenuInputValidator.validateMenuSelection("Station", " ");
        MenuInputValidator.validateMenuSelection("Station", "+~");
        MenuInputValidator.validateMenuSelection("Station", "b");
    }
    
    @Test(expected = MenuInputException.class)
    public void testLineMenuSelection() {
        MenuInputValidator.validateMenuSelection("Line", "4");
        MenuInputValidator.validateMenuSelection("Line", " ");
        MenuInputValidator.validateMenuSelection("Line", "+~");
        MenuInputValidator.validateMenuSelection("Line", "b");
    }
    
    @Test(expected = MenuInputException.class)
    public void testSectionMenuSelection() {
        MenuInputValidator.validateMenuSelection("Section", "3");
        MenuInputValidator.validateMenuSelection("Section", " ");
        MenuInputValidator.validateMenuSelection("Section", "+~");
        MenuInputValidator.validateMenuSelection("Section", "b");
    }
}
