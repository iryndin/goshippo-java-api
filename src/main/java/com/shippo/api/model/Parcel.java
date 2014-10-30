package com.shippo.api.model;

import java.math.BigDecimal;

public class Parcel {
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private DistanceUnitEnum distanceUnit;
    private BigDecimal weight;
    private MassUnitEnum massUnit;
    private String template;
    private String metadata;

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public DistanceUnitEnum getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(DistanceUnitEnum distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public MassUnitEnum getMassUnit() {
        return massUnit;
    }

    public void setMassUnit(MassUnitEnum massUnit) {
        this.massUnit = massUnit;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", distanceUnit=" + distanceUnit +
                ", weight=" + weight +
                ", massUnit=" + massUnit +
                ", template='" + template + '\'' +
                ", metadata='" + metadata + '\'' +
                '}';
    }
}
