package com.example.phoenix.SignUpLayout;

public class assistant_model {
    String assistantName ;
    String assistantPhone;
    String assistantWhatsAppNumber;
    String assistantPIN;

    public String getAssistantName() {
        return assistantName;
    }

    public String getAssistantPhone() {
        return assistantPhone;
    }

    public String getAssistantWhatsAppNumber() {
        return assistantWhatsAppNumber;
    }

    public String getAssistantPIN() {
        return assistantPIN;
    }


    public assistant_model(String assistantName, String assistantPhone, String assistantWhatsAppNumber, String assistantPIN) {
        this.assistantName = assistantName;
        this.assistantPhone = assistantPhone;
        this.assistantWhatsAppNumber = assistantWhatsAppNumber;
        this.assistantPIN = assistantPIN;
    }


}
