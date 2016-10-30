package com.superinc.europe.onlineshopping.su.web.utils;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.superinc.europe.onlineshopping.gu.entities.dto.DepartmentVO;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;
import com.superinc.europe.onlineshopping.gu.service.IProductCategoryService;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.HttpUtils;

@Controller
@Scope("session")
public class DepartmentEditor extends PropertyEditorSupport {
	
	Logger log = Logger.getLogger(DepartmentEditor.class);

    @Autowired
    private IProductCategoryService productCategoryService;
	
    @Override
    public void setAsText(String id) {
    	
		List<Category> categoryList = getCategoryList();

		DepartmentVO d = null;
	for (Category category : categoryList) {
		if (Integer.parseInt(id)==category.getCategoryId()){
			d =  new DepartmentVO(category.getCategoryId(),  category.getCategoryname());
			break;
		}
		else{
			d = null;
		}
	}
	this.setValue(d);

//	DepartmentVO d;
//	switch(Integer.parseInt(id))
//	{
//		
//		case 1: d = new DepartmentVO(1,  "Tv"); break;
//		case 2: d = new DepartmentVO(2,  "Phone"); break;
//		case 3: d = new DepartmentVO(3,  "Notebook"); break;
//		case 4: d = new DepartmentVO(4,  "Photo"); break;
//		case 5: d = new DepartmentVO(5,  "Fridge"); break;
//		case 6: d = new DepartmentVO(6,  "Tabled"); break;
//		case 7: d = new DepartmentVO(7,  "Other"); break;
//		default: d = null;
//	}
//    this.setValue(d);s
    }
    
    private boolean checkToNull(List<Category> categoryList){
		if(categoryList==null){
    	return false;
		}
		return true;
    }
    
    private List<Category> getCategoryList(){
    	List<Category> categoryList = HttpUtils.getList();
    	if (checkToNull(categoryList)){
    		return categoryList;
    	}
		return new ArrayList<Category>();
    	
    }
}