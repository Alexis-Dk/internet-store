package com.superinc.europe.onlineshopping.su.web.utils;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.superinc.europe.onlineshopping.gu.entities.dto.CharacteristicFiveVO;
import com.superinc.europe.onlineshopping.gu.entities.dto.CharacteristicFourVO;
import com.superinc.europe.onlineshopping.gu.entities.dto.CharacteristicOneVO;
import com.superinc.europe.onlineshopping.gu.entities.dto.CharacteristicTwoVO;
import com.superinc.europe.onlineshopping.gu.entities.dto.DepartmentVO;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;
import com.superinc.europe.onlineshopping.gu.service.IProductCategoryService;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.HttpUtils;
import com.superinc.europe.onlineshopping.su.entities.pojo.Characteristic;

@Controller
@Scope("session")
public class CharacteristicFourEditor extends PropertyEditorSupport {
	
	Logger log = Logger.getLogger(CharacteristicFourEditor.class);

    @Autowired
    private IProductCategoryService productCategoryService;
	
    @Override
    public void setAsText(String id) {

    	CharacteristicFourVO ob = null;

		List<Characteristic> list = getCharacteristicFourList();
		for (Characteristic characteristic : list) {
			if (!characteristic.getCategoryCharacteristicFk().isCategoryCharacteristicEnable()){
				ob = new CharacteristicFourVO(characteristic.getCharacteristicId(), "Disabled");
				break;
			}
			
			if (Integer.parseInt(id)==characteristic.getCharacteristicId()){
				ob =  new CharacteristicFourVO(characteristic.getCharacteristicId(), characteristic.getCharacteristicName());
				break;
			}
			else{
				ob = null;
			}
		}
		this.setValue(ob);
    }
    
    private boolean checkToNull(List<Characteristic> characteristicList){
		if(characteristicList==null){
    	return false;
		}
		return true;
    }
    
    private List<Characteristic> getCharacteristicFourList(){
    	List<Characteristic> characteristicList = HttpUtils.getCharacteristicFourList();
    	if (checkToNull(characteristicList)){
    		return characteristicList;
    	}
		return new ArrayList<Characteristic>();
    	
    }
}