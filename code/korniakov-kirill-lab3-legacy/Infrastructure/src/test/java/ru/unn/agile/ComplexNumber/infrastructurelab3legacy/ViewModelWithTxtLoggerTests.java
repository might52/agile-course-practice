package ru.unn.agile.complexnumber.infrastructurelab3legacy;

import ru.unn.agile.complexnumber.viewmodellab3legacy.ViewModel;
import ru.unn.agile.complexnumber.viewmodellab3legacy.ViewModelTests;

public class ViewModelWithTxtLoggerTests extends ViewModelTests {
    @Override
    public void setUp() {
        TxtLogger realLogger =
            new TxtLogger("./ViewModelWithTxtLoggerTests-lab3-legacy.log");
        super.setViewModel(new ViewModel(realLogger));
    }
}
