package demo.vo;

import lombok.Data;


@Data
public class DemoGoodsVo {
    String goodsName;
    String price;
    String cusName;
    String errStep;
    boolean doWrite;
}
