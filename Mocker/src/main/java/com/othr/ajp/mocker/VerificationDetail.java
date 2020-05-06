package com.othr.ajp.mocker;

public class VerificationDetail<A> {
    public enum VerificationDetailType {
        TIMES, NEVER, ATMOST, ATLEAST
    }

    protected final VerificationDetailType detailType;
    private final A detail;

    public VerificationDetail(A detail, VerificationDetailType detailType) {
        this.detail = detail;
        this.detailType = detailType;
    }

    public static <B> VerificationDetail<B> newInstance(B detail, VerificationDetailType detailType) {
        return new VerificationDetail<>(detail, detailType);
    }

    protected A getDetail() {
        return detail;
    }
}
