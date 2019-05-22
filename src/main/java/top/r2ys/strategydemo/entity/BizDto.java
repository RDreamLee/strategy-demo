package top.r2ys.strategydemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 14:17
 */
@Data
@Getter
@Setter
@AllArgsConstructor
public class BizDto {

    private String bizType;

    private String bizData;

}
