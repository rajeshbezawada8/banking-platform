package com.bank.customerservice.model.enums;

public enum ContentType {
    PDF("application/pdf"),
    JPG("image/jpg"),
    JPEG("image/jpeg");

    private final String mimeType;

    ContentType(final String mimeType) {
        this.mimeType = mimeType;
    }

    public static ContentType fromMimeType(String mimeType) {
        for (ContentType Type : values()) {
            if (Type.mimeType.equalsIgnoreCase(mimeType)) {
                return Type;
            }
        }
        throw new IllegalArgumentException("No such mime type: " + mimeType);
    }

    public String getMimeType() {
        return mimeType;
    }
}
