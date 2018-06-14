package nanpasun.wod_timer;

public class RMCalculator {

    public long defaultRm(double weight, double number) {
        return  Math.round(weight + (weight * 0.025 * number));
    }

    public long EpleyRm(double weight, double number) {
        return  Math.round(weight * (1 + (number / 30)));
    }

    public long BrzyckiRM(double weight, double number) {
        return  Math.round(weight / (1.0278 - (0.0278 * number)));
    }

    public long BaechleRM(double weight, double number) {
        return  Math.round(weight * (1 + (0.033 * number)));
    }

    public long LandersRM(double weight, double number) {
        return  Math.round((100 * weight) / (101.3- (2.67123 * number)));
    }
}
