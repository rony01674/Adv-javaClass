package nganjGym.pojo;

/**
 *
 * @author Asaduzzaman Rony
 */
public class MembershipPlan {
    private String planID;
    private String planType;
    private String planDuration;
    private double planFee;

    public MembershipPlan() {
    }

    public MembershipPlan(String planID, String planType, String planDuration, double planFee) {
        this.planID = planID;
        this.planType = planType;
        this.planDuration = planDuration;
        this.planFee = planFee;
    }

    public String getPlanID() {
        return planID;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getPlanDuration() {
        return planDuration;
    }

    public void setPlanDuration(String planDuration) {
        this.planDuration = planDuration;
    }

    public double getPlanFee() {
        return planFee;
    }

    public void setPlanFee(double planFee) {
        this.planFee = planFee;
    }
    
    
}
