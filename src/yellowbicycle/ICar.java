package yellowbicycle;

import java.util.concurrent.Delayed;

public interface ICar extends Delayed {
    /**
     * 运输车
     *@Author lzn
     *@Date 2022/11/25 10:39
     *@Version 1.0
     *@param :
     *@return {@link null}
     **/
    public int speed();

    public int add(int n);

    public int delete();

    public void setToStation(IStation iStation);
    public void setCurStation(IStation iStation);
    public IStation getCurStation();
    public IStation getToStation();
    public void  setDis(long dis);
    public int getBicycle();


}
