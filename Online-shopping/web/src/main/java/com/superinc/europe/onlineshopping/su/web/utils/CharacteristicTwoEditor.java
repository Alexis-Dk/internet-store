package com.superinc.europe.onlineshopping.su.web.utils;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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
public class CharacteristicTwoEditor extends PropertyEditorSupport {
	
	Logger log = Logger.getLogger(CharacteristicTwoEditor.class);

    @Autowired
    private IProductCategoryService productCategoryService;
	
    @Override
    public void setAsText(String id) {

    	CharacteristicTwoVO ob = null;

		List<Characteristic> list = getCharacteristicTwoList();
		for (Characteristic characteristic : list) {
			if (!characteristic.getCategoryCharacteristicFk().isCategoryCharacteristicEnable()){
				ob = new CharacteristicTwoVO(characteristic.getCharacteristicId(), "Disabled");
				break;
			}
			
			if (Integer.parseInt(id)==characteristic.getCharacteristicId()){
				ob =  new CharacteristicTwoVO(characteristic.getCharacteristicId(), characteristic.getCharacteristicName());
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
    
    private List<Characteristic> getCharacteristicTwoList(){
    	List<Characteristic> characteristicList = HttpUtils.getCharacteristicTwoList();
    	if (checkToNull(characteristicList)){
    		return characteristicList;
    	}
		return new ArrayList<Characteristic>();
    	
    }
}