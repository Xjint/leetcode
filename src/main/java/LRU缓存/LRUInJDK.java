package LRU缓存;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @author baijintao
 * @date 2021/9/13 9:02 下午
 */
public class LRUInJDK<K, V> extends LinkedHashMap<K, V> {

  private Integer maxEle;


  public LRUInJDK(Integer maxEle) {
    super();
    this.maxEle = maxEle;
  }

  @Override
  protected boolean removeEldestEntry(Entry<K, V> eldest) {
    return size() > this.maxEle;
  }
}
