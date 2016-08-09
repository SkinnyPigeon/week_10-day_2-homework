public class Salmon implements Edible, Gillable {

  public String swim() {
    return "splish splish splash";
  }

  public int nutritionValue() {
    return 10;
  }

  public boolean gillValue() {
    return true;
  }

}