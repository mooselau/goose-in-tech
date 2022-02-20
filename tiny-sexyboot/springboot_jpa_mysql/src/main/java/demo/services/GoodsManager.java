package demo.services;

import static demo.converters.GoodsConverter.convert;
import static demo.utils.CustomerUtil.buildGoods;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import demo.jpa.entity.Goods;
import demo.jpa.repo.GoodsRepository;
import demo.vo.GoodsVo;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class GoodsManager {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Long createGoods(GoodsVo goodsVo) {
        Goods newGoods = buildGoods(goodsVo.getGoodsName(), Double.parseDouble(goodsVo.getPrice()));
        newGoods = goodsRepository.save(newGoods);
        return newGoods.getId();
    }

    @Transactional
    public Long updateGoods(GoodsVo goodsVo) {
        Long goodsId = Long.parseLong(goodsVo.getGoodsId());
        Goods goods = goodsRepository.queryGoodsByGoodsIdForUpdate(goodsId).orElseThrow(() -> new RuntimeException("No Goods Found"));

         entityManager.detach(goods);

        goods.setName(goodsVo.getGoodsName());
        goods.setPrice(Double.parseDouble(goodsVo.getPrice()));
        // goodsRepository.save(goods);
        return goodsId;
    }

    public GoodsVo getGoods(Long goodsId) {
        Goods goods = goodsRepository.findById(goodsId).orElseThrow(() -> new RuntimeException("No Goods Found"));
        return convert(goods);
    }

    public GoodsVo getGoodsByQuery(Long goodsId) {
        Goods goods = goodsRepository.queryGoodsByGoodsIdForUpdate(goodsId).orElseThrow(() -> new RuntimeException("No Goods Found"));
        return convert(goods);
    }
}
