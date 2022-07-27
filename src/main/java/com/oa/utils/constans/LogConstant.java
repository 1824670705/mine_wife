package com.oa.utils.constans;

import com.oa.application.goods.controller.GoodsController;
import com.oa.application.life.controller.OaBillController;
import com.oa.application.life.controller.OaBillReportController;
import com.oa.application.log.controller.LogController;
import com.oa.application.menu.controller.OaMenuController;
import com.oa.application.order.controller.OaOrderController;
import com.oa.application.order.controller.OaOrderReportController;
import com.oa.application.other.controller.FileController;
import com.oa.application.other.controller.OaAreaController;
import com.oa.application.user.controller.OaLocalUserController;
import com.oa.application.user.controller.OaSupplierController;
import com.oa.application.user.controller.OaUserController;
import lombok.Getter;

public class LogConstant {

    public interface LogTypeConstant {

        /**
         * 默认值，未知的类型
         */
        Integer defaultType = 0;
        Integer deleteType = 1;
        Integer createType = 2;
        Integer updateType = 3;
        Integer accountType = 4;
        Integer rejectType = 5;
        Integer loginType = 6;
        Integer loginOutType = 7;

        /**
         * 异常类型
         */
        Integer exceptionType = 8;
    }

    public enum LogModuleConstant {
        LOG_MODULE("日志模块", LogController.class),
        BILL_MODULE("账单模块", OaBillController.class),
        FILE_MODULE("文件模块", FileController.class),
        AREA_MODULE("地域模块", OaAreaController.class),
        ORDER_MODULE("订单模块", OaOrderController.class),
        USER_MODULE("用户模块", OaUserController.class),
        SUPPLIER_MODULE("供应商模块", OaSupplierController.class),
        GOODS_MODULE("单品管理模块", GoodsController.class),
        ENUM_MODULE("字典管理模块", OaMenuController.class),
        LOCATION_MODULE("用户地址信息模块", OaLocalUserController.class),
        REPORT_BILL_MODULE("报表-账单管理-模块", OaBillReportController.class),
        REPORT_ORDER_MODULE("报表-订单管理-模块", OaOrderReportController.class),
        ;

        @Getter
        private String desc;
        @Getter
        private Class<?> moduleController;


        LogModuleConstant(String desc, Class<?> moduleController) {
            this.desc = desc;
            this.moduleController = moduleController;
        }
    }
}
