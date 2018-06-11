package main.AttackChoice;

import main.AuthPresenterImpl;
import main.AuthView;

/**
 * Created by gcalori on 26/03/2018.
 */

public class AttackChoicePresenterImpl extends AuthPresenterImpl implements AttackChoicePresenter {

    private AttackChoiceView view;

    public AttackChoiceView getView() {
        return view;
    }

    AttackChoicePresenterImpl(AttackChoiceView view) {
        this.view = view;
    }

    @Override
    protected AuthView getAuthView() {
        return view;
    }

    @Override
    public void onAttack() {
        view.onAttack();
    }
}
