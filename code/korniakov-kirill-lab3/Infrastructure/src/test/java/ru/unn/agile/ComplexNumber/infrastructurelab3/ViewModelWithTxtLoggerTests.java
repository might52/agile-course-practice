package ru.unn.agile.complexnumber.infrastructurelab3;

import ru.unn.agile.complexnumber.viewmodellab3.ViewModel;
import ru.unn.agile.complexnumber.viewmodellab3.ViewModelTests;

public class ViewModelWithTxtLoggerTests extends ViewModelTests {
    @Override
    public void setUp() {
        TxtLogger realLogger =
            new TxtLogger("./ViewModel_with_TxtLogger_Tests-lab3.log");
        super.setExternalViewModel(new ViewModel(realLogger));
    }
}
