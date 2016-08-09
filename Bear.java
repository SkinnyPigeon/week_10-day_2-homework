import java.util.*;

public class Bear{
  
  private String name;
  private ArrayList< Edible > belly;
  private Journal journal;


  public Bear( String name, Journal journal ){
    this.name = name;
    this.belly = new ArrayList< Edible >();
    this.journal = journal;
  }

  public String getName(){
    return this.name;
  }

  public int foodCount(){
    return belly.size();
  }

  public int journalSize() {
    return journal.journalCount();
  }

  public int readDay( String day ) {
    return journal.dayCount( day );
  }

  public void eat( Edible food, String day ){
    belly.add( food );
    this.journal.write( day, belly.size() );
  }

  public void eatBreakfast( Edible food ) {
    try {
      Lungable lFood = ( Lungable ) food;
      belly.add( food );
    } catch( ClassCastException e ) {
      System.err.println( e );
    }
  }

  public void eatDinner( Edible food ) {
    try {
      Gillable gFood = ( Gillable ) food;
      belly.add( food );
    } catch( ClassCastException e ) {
      System.err.println( e );
    }
  }

  public Edible throwUp() {
    if( foodCount() > 0 ) {
      return belly.remove( 0 );
    }
    return null;
  }

  public void sleep(){
    belly.clear();
  }

  public int totalNutrition() {
    int value = 0;
    for( Edible food : belly ) {
      value += food.nutritionValue();
    }
    return value;
  }



}
