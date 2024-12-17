public class RecyclingMaterial {
    private String materialType;
    private double weight;
    private double impactFactor;

    // Constructor
    public RecyclingMaterial(String materialType, double weight, double impactFactor) {
        this.materialType = materialType;
        this.weight = weight;
        this.impactFactor = impactFactor;
    }

    // Getter methods
    public String getMaterialType() {
        return materialType;
    }

    public double getWeight() {
        return weight;
    }

    public double getImpactFactor() {
        return impactFactor;
    }

    // Setter methods (optional, if you need them)
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setImpactFactor(double impactFactor) {
        this.impactFactor = impactFactor;
    }
}
