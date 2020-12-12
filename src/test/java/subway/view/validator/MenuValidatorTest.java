package subway.view.validator;

import org.junit.Test;

import subway.view.exception.MenuSelectionException;
import subway.view.exception.MenuValidator;

public class MenuValidatorTest {
    @Test(expected = MenuSelectionException.class)
    public void testMainMenuSelection() {
        MenuValidator.validateMenuSelection("Main", "5");
        MenuValidator.validateMenuSelection("Main", " ");
        MenuValidator.validateMenuSelection("Main", "+~");
        MenuValidator.validateMenuSelection("Main", "q");
    }
    
    @Test(expected = MenuSelectionException.class)
    public void testStationMenuSelection() {
        MenuValidator.validateMenuSelection("Station", "4");
        MenuValidator.validateMenuSelection("Station", " ");
        MenuValidator.validateMenuSelection("Station", "+~");
        MenuValidator.validateMenuSelection("Station", "b");
    }
    
    @Test(expected = MenuSelectionException.class)
    public void testLineMenuSelection() {
        MenuValidator.validateMenuSelection("Line", "4");
        MenuValidator.validateMenuSelection("Line", " ");
        MenuValidator.validateMenuSelection("Line", "+~");
        MenuValidator.validateMenuSelection("Line", "b");
    }
    
    @Test(expected = MenuSelectionException.class)
    public void testSectionMenuSelection() {
        MenuValidator.validateMenuSelection("Section", "3");
        MenuValidator.validateMenuSelection("Section", " ");
        MenuValidator.validateMenuSelection("Section", "+~");
        MenuValidator.validateMenuSelection("Section", "b");
    }
}
