package com.learning.paymentservice.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "PAYMENT", catalog = "postgres")
public class Payment implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PAYMENT_ID", nullable = false)
    private Long paymentId;

    @Column(name = "ORDER_ID", nullable = false)
    private Long orderId;

    @Column(name = "PAYMENT_MODE", nullable = false)
    private String paymentMode;

    @Column(name = "REFERENCE_NUMBER", nullable = false)
    private String referenceNumber;

    @Column(name = "PAYMENT_DATE", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "PAYMENT_STATUS", nullable = false)
    private String paymentStatus;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    public Payment() {
    }

    public Payment(Long paymentId, Long orderId, String paymentMode, String referenceNumber, LocalDateTime paymentDate, String paymentStatus, BigDecimal amount) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentMode = paymentMode;
        this.referenceNumber = referenceNumber;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentId, payment.paymentId) &&
                Objects.equals(orderId, payment.orderId) &&
                Objects.equals(paymentMode, payment.paymentMode) &&
                Objects.equals(referenceNumber, payment.referenceNumber) &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(paymentStatus, payment.paymentStatus) &&
                Objects.equals(amount, payment.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, orderId, paymentMode, referenceNumber, paymentDate, paymentStatus, amount);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", orderId=" + orderId +
                ", paymentMode='" + paymentMode + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", paymentDate=" + paymentDate +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public static final class PaymentBuilder {
        private Long paymentId;
        private Long orderId;
        private String paymentMode;
        private String referenceNumber;
        private LocalDateTime paymentDate;
        private String paymentStatus;
        private BigDecimal amount;

        private PaymentBuilder() {
        }

        public static PaymentBuilder builder() {
            return new PaymentBuilder();
        }

        public PaymentBuilder paymentId(Long paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public PaymentBuilder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public PaymentBuilder paymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
            return this;
        }

        public PaymentBuilder referenceNumber(String referenceNumber) {
            this.referenceNumber = referenceNumber;
            return this;
        }

        public PaymentBuilder paymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public PaymentBuilder paymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public PaymentBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Payment build() {
            Payment payment = new Payment();
            payment.setPaymentId(paymentId);
            payment.setOrderId(orderId);
            payment.setPaymentMode(paymentMode);
            payment.setReferenceNumber(referenceNumber);
            payment.setPaymentDate(paymentDate);
            payment.setPaymentStatus(paymentStatus);
            payment.setAmount(amount);
            return payment;
        }
    }
}
