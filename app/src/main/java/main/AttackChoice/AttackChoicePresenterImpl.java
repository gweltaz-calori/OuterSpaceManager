package main.AttackChoice;

/**
 * Created by gcalori on 26/03/2018.
 */

public class AttackChoicePresenterImpl  implements AttackChoicePresenter {

    private AttackChoiceView view;

    public AttackChoiceView getView() {
        return view;
    }

    AttackChoicePresenterImpl(AttackChoiceView view) {
        this.view = view;
    }
}
