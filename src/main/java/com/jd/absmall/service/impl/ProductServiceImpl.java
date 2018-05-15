package com.jd.absmall.service.impl;

import com.jd.absmall.entity.Product;
import com.jd.absmall.mapper.ProductMapper;
import com.jd.absmall.service.ProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 产品表 服务实现类
 * </p>
 *
 * @author dongzhihua
 * @since 2018-05-10
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateProduct(Product product) {
		boolean success = super.baseMapper.updateProduct(product) == 1;
		if (success) {
			throw new RuntimeException("Tran");
		}
		return success;
	}
}
