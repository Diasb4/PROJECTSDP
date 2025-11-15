package strategy.concrete_strategy;

import strategy.PaymentStrategy;

public class QRPayment implements PaymentStrategy {

    private String qrCode;
    private boolean isQRCodeValid;
    private String maskedQRCode;

    public QRPayment(String qrCode) {
        this.qrCode = qrCode;
        this.isQRCodeValid = isValidQRCode();
        this.maskedQRCode = getMaskedQRCode();
    }

    @Override
    public boolean processPayment(double amount) {
        if (isQRCodeValid) {
            System.out.println("QR payment successful! Amount: $" + String.format("%.2f", amount));
            System.out.println("  Transaction completed via QR code: " + maskedQRCode);
            return true;
        } else {
            System.out.println("QR payment failed! Invalid QR code.");
            return false;
        }
    }

    @Override
    public String getPaymentMethodName() {
        return "QR Code Payment";
    }

    @Override
    public String getPaymentDetails() {
        return "QR Code: " + maskedQRCode;
    }

    private boolean isValidQRCode() {
        return qrCode != null && qrCode.startsWith("QR") && qrCode.length() > 5;
    }

    private String getMaskedQRCode() {
        if (qrCode.length() <= 8)
            return qrCode;
        return qrCode.substring(0, 4) + "..." + qrCode.substring(qrCode.length() - 4);
    }

    public String getQrCode() {
        return qrCode;
    }
}