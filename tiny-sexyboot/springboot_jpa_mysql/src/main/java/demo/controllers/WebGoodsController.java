package demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import demo.services.GoodsManager;
import demo.vo.GoodsVo;


@RestController
public class WebGoodsController {

    @Autowired
    private GoodsManager goodsManager;

    @GetMapping("/demo/goods/{id}")
    public ResponseEntity<GoodsVo> demoGetGoods(@PathVariable("id") String id) {
        GoodsVo goodsVo = goodsManager.getGoods(Long.parseLong(id));
//        GoodsVo goodsVo = goodsManager.getGoodsByQuery(Long.parseLong(id));
        return ResponseEntity.ok(goodsVo);
    }

    @PostMapping("/demo/goods")
    public ResponseEntity<Long> createGoods(@RequestBody GoodsVo goodsVo) {
        Long goodsId = goodsManager.createGoods(goodsVo);
        return ResponseEntity.ok(goodsId);
    }

    @PutMapping("/demo/goods")
    public ResponseEntity<Long> updateGoods(@RequestBody GoodsVo goodsVo) {
        Long goodsId = goodsManager.updateGoods(goodsVo);
        return ResponseEntity.ok(goodsId);
    }
}
