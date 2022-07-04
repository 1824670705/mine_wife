package com.oa.module;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oa.application.other.entity.OaArea;
import com.oa.application.other.service.IOaAreaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
public class AreaModuleTest {

    @Autowired
    private IOaAreaService iOaAreaService;

    @Test
//    @Transactional(rollbackFor = Exception.class)
    public void setFullContent() {
        int current = 0;
        for (; ; ) {
            Page<OaArea> page = new Page<>(current, 10000);
            Page<OaArea> areaData = getAreaData(page);
            // 执行更新操作
            toUpdateAreaFullContent(areaData.getRecords());
            if (areaData.getPages() == current) {
                log.info("结束执行，完成更新操作");
                break;
            } else {
                current++;
                log.info("开始下一次的更新操作 ----> {}", current);
            }
        }
    }

    /**
     * batch 更新数据
     *
     * @param records 数据
     */
    private void toUpdateAreaFullContent(List<OaArea> records) {
        List<OaArea> collect = records.stream().parallel().peek(v -> {
            v.setAreaFullName(iOaAreaService.getFullAreaName(v.getAreaCode(), "/"))
                    .setAreaFullCode(iOaAreaService.getFullAreaCode(v.getAreaCode(), "/"));
        }).collect(Collectors.toList());
        if (!ObjectUtils.isEmpty(collect)) {
            iOaAreaService.updateBatchById(collect);
        }
    }

    /**
     * 分页获取数据
     *
     * @param page 分页信息
     * @return 分页数据
     */
    private Page<OaArea> getAreaData(Page<OaArea> page) {
        return iOaAreaService.page(page);
    }
}
