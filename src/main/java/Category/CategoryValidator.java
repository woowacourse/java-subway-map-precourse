package Category;

import Category.Exception.NotValidInputCategory;

import java.util.List;

public class CategoryValidator {

    public void isValidCategory(String input, List<String> actionType) {
        if (!actionType.contains(input))
            throw new NotValidInputCategory();
    }
}
