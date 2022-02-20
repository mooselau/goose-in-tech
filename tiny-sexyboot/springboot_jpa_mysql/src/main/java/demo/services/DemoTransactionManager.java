package demo.services;

import static demo.utils.CustomerUtil.buildCustomer;
import static demo.utils.CustomerUtil.buildGoods;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import demo.jpa.entity.Customer;
import demo.jpa.entity.Goods;
import demo.jpa.repo.CustomerRepository;
import demo.jpa.repo.GoodsRepository;
import demo.vo.DemoGoodsVo;
import lombok.extern.slf4j.Slf4j;


/**
 * This is used to test Transactional.
 */
@Slf4j
@Service
public class DemoTransactionManager {
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DemoTxnManager02 demoTxnManager02;
    @Autowired
    private CommonCounter counter;
    private Integer internalCounter = 0;

    @PostConstruct
    private void init() {
        Goods newGoods = buildGoods("Toy Bear", 1.00d);
        goodsRepository.save(newGoods);
    }

    @Transactional(readOnly = true)
    public void demoReadOnlyFunction(boolean writeAttempt) {
        if (writeAttempt) {
            Goods newGoods = buildGoods("Toy", 1.00d);
            Goods saved = goodsRepository.save(newGoods);
            LOGGER.info("NEW Goods[{}] saved", saved.getId());
        } else {
            Goods goods = goodsRepository.findById(1L).orElse(new Goods());
            LOGGER.info("Existing Goods[{}] found", goods.getName());
        }
    }

    @Transactional
    public void demoFunction03(DemoGoodsVo goodsVo) {
        String err = goodsVo.getErrStep();
        // prepare entity
        Goods newGoods = buildGoods(goodsVo.getGoodsName(), Double.parseDouble(goodsVo.getPrice()));
        // step1 to change local var
        setStep1(err);
        // save entity
        Goods saved = goodsRepository.save(newGoods);
        // step2 to change object
        setStep2(err);
        // save customer entity
        Long saved02Id = demoTxnManager02.demoNewFunction(goodsVo.getCusName());
        // step3 to change object
        step3(err);
        LOGGER.info("NEW Goods[{}], NEW Customer[{}] saved", saved.getId(), saved02Id);
    }

    @Transactional
    public void demoFunction02(DemoGoodsVo goodsVo) {
        String err = goodsVo.getErrStep();
        // prepare entity
        Goods newGoods = buildGoods(goodsVo.getGoodsName(), Double.parseDouble(goodsVo.getPrice()));
        Customer newCustomer = buildCustomer(goodsVo.getCusName());
        // step1 to change local var
        setStep1(err);
        // save entity at last
        Goods saved = goodsRepository.save(newGoods);
        // step2 to change object
        setStep2(err);
        Customer saved02 = customerRepository.save(newCustomer);
        // step3 to change object
        step3(err);
        LOGGER.info("NEW Goods[{}], NEW Customer[{}] saved", saved.getId(), saved02.getId());
    }

    @Transactional
    public void demoFunction(DemoGoodsVo goodsVo) {
        String err = goodsVo.getErrStep();
        // prepare entity
        Goods newGoods = buildGoods(goodsVo.getGoodsName(), Double.parseDouble(goodsVo.getPrice()));
        // step1 to change local var
        setStep1(err);
        // step2 to change object
        setStep2(err);
        // save entity at last
        Goods saved = goodsRepository.save(newGoods);
        // step3 to change object
        step3(err);
        LOGGER.info("NEW Goods[{}] saved", saved.getId());
    }

    private void setStep1(String err) {
        if ("step1".equals(err)) {
            throw new RuntimeException("Step1 Exception is throwing..");
        }
        // local var change
        internalCounter++;
    }

    private void setStep2(String err) {
        if ("step2".equals(err)) {
            throw new RuntimeException("Step2 Exception is throwing..");
        }
        // object change
        counter.addOne();
    }

    private void step3(String err) {
        if ("step3".equals(err)) {
            throw new RuntimeException("Step3 Exception is throwing..");
        }
        LOGGER.info("Step 3 is good");
    }

    public void printDemoInfo() {
        LOGGER.info("====================");
        LOGGER.info("Internal Counter: {}", internalCounter);
        LOGGER.info("CommonCounter Counter: {}", counter.getCount());
        LOGGER.info("====================");
    }
}
