import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;


public class BearTest{
  Bear bear;
  Salmon salmon;
  Human human;
  Chicken chicken;
  Journal journal;

  @Before 
  public void before() {
    journal = new Journal();
    bear = new Bear("Baloo", journal );
    salmon = new Salmon(); 
    human = new Human();
    chicken = new Chicken();
  }

  @Test
  public void diaryHasEntry() {
    bear.eat( chicken, "Monday" );
    // assertEquals( 1, bear.foodCount() );
    assertEquals( 1, bear.journalSize() );
  }

  @Test
  public void diaryHasMultipleEntries() {
    bear.eat( chicken, "Monday" );
    bear.eat( chicken, "Monday" );
    bear.eat( chicken, "Tuesday" );
    bear.eat( chicken, "Wednesday" );
    bear.eat( chicken, "Thursday" );
    bear.eat( chicken, "Friday" );
    bear.eat( chicken, "Saturday" );
    assertEquals( 6, bear.journalSize() );
  }

  @Test
  public void diaryCanTellTheFoodCountPerDay() {
    bear.eat( chicken, "Monday" );
    bear.eat( chicken, "Monday" );
    assertEquals( 2, bear.readDay( "Monday" ) );
  }

  @Test
  public void hasName(){
    assertEquals( "Baloo", bear.getName() ); 
  }

  @Test
  public void bellyStartsEmpty(){
    assertEquals(0, bear.foodCount());
  }

  @Test
  public void canEatSalmon(){
    bear.eat(salmon, "Monday");
    assertEquals(1, bear.foodCount());
  }

  @Test
  public void canEatHuman() {
    bear.eat( human, "Monday" );
    assertEquals( 1, bear.foodCount() );
  }

  @Test
  public void shouldEmptyBellyAfterSleeping(){
    bear.eat(salmon, "Monday" );
    bear.sleep();
    assertEquals(bear.foodCount(), 0);
  }

  @Test
  public void canThrowUp() {
    bear.eat( salmon, "Monday" );
    Edible food = bear.throwUp();
    Salmon original = ( Salmon ) food;
    assertEquals( "splish splish splash", original.swim() );
  }

  @Test
  public void canEatChicken() {
    bear.eat( chicken, "Monday" );
    assertEquals( 1, bear.foodCount() );
  }

  @Test
  public void canThrowUpChicken() {
    bear.eat( chicken, "Monday" );
    Edible food = bear.throwUp();
    Chicken original = ( Chicken ) food;
    assertEquals( "Bwark", original.cluck() );
  }

  @Test
  public void hasNutrition() {
    bear.eat( chicken, "Monday" );
    bear.eat( chicken, "Monday" );
    assertEquals( 10, bear.totalNutrition() );
  }

  @Test
  public void noFishForBreakfast() {
    bear.eatBreakfast( salmon );
    assertEquals( 0, bear.foodCount() );
  }

  @Test
  public void noLungedBeastsForDinner() {
    bear.eatDinner( human );
    assertEquals( 0, bear.foodCount() );
  }

  @Test
  public void eatFishForDinner() {
    bear.eatDinner( salmon );
    assertEquals( 1, bear.foodCount() );
  }

  @Test
  public void eatLungedBeastsForBreakfast() {
    bear.eatBreakfast( human );
    assertEquals( 1, bear.foodCount() );
  }

  // interface segregation principal

// abstraction
  // encapsulation
  // polymorphism
  // inheritance

  // 4 pillars of OOP
}






