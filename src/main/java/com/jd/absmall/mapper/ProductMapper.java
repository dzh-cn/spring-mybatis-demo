package com.jd.absmall.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jd.absmall.entity.Product;

import java.util.List;

/**
 * <p>
 * 产品表 Mapper 接口
 * </p>
 *
 * @author dongzhihua
 * @since 2018-05-10
 */
public interface ProductMapper extends BaseMapper<Product> {

	Product queryProduct(int productId);

	List<Product> queryProducts();

	int updateProduct(Product product);
}
