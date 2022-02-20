package demo.converters;

import demo.jpa.entity.Goods;
import demo.vo.GoodsVo;


public final class GoodsConverter {
    private GoodsConverter() {
    }

    public static GoodsVo convert(Goods goods) {
        GoodsVo goodsVo = new GoodsVo();
        goodsVo.setGoodsId(String.valueOf(goods.getId()));
        goodsVo.setGoodsName(goods.getName());
        goodsVo.setPrice(String.valueOf(goods.getPrice()));
        return goodsVo;
    }
}
