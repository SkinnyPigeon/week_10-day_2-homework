import java.util.*;

public class Journal {

  private HashMap< String, Integer > diary;

  public Journal() {
    this.diary = new HashMap< String, Integer >();
  }

  public void write( String key, Integer value ) {
    this.diary.put( key, value );
  }

  public int journalCount() {
    return this.diary.size();
  }

  public int dayCount( String day ) {
    return this.diary.get(day);
  } 

}
