package com.othr.ajp.annotations;

import static com.othr.ajp.annotations.Criticality.*;

@Review(reviewers = {"John Doe", "Max Mustermann"}, criticality = SEVERE)
public class SampleAnnotatedClass {

    @PublishOnline("http://othr.de/aj[/services/testresult")
    public double getTestResultByStudentId(String studentId) {
        return 0.0;
    }

    @PublishOnline
    public String getHelpText() {
        return "helping text";
    }

    public static void main(String[] args) {

    }
}
