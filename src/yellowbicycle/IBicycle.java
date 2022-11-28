package yellowbicycle;

import java.util.concurrent.Delayed;

/**
 * @author luzhengnan
 */
public interface IBicycle extends Delayed {
    /**
     *
     *@Author lzn
     *@Date 2022/11/25 10:39
     *@Version 1.0
     *@param :
     *@return {@link null}
     **/
    public int speed();

    public IStation getTo();

    public void setDis(long dis);
}
