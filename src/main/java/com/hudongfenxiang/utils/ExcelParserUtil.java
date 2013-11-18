/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hudongfenxiang.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @FileName     :  ExcelParserUtil.java
 * @Encoding     :  UTF-8
 * @Package      :  com.lezhai365.utils
 * @Link         :  http://lezhai365.com
 * @Created on   :  2013-9-9, 10:13:04
 * @Author       :  WeiPeng.Liu  [liuweipeng@lezhai365.com]
 * @Version      :  1.0
 * @Copyright    :  Copyright(c) 2013 西安乐宅网络科技有限公司
 * @Description  :
 *
 */
public class ExcelParserUtil {
        
	
	private Logger logger=Logger.getLogger(ExcelParserUtil.class);
	
	private HSSFWorkbook workbook;
	
	public ExcelParserUtil(File file){
		try {
			//获取工作薄workbook
			workbook=new HSSFWorkbook(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List getDataInsheet(int sheetNumber){
		List<List<Object>> result=new ArrayList<List<Object>>();
		//获取指定的sheet
		HSSFSheet sheet=workbook.getSheetAt(sheetNumber);
		//获取sheet总行数
		int rowCount=sheet.getLastRowNum();
		logger.info("EXCEL表格总行数:"+rowCount);
		if(rowCount<1){
			return result;
		}
		//遍历row
		for(int i=0;i<rowCount;i++){
			//获得行对象
			HSSFRow row=sheet.getRow(i);
			if(null!=row){
				List<Object> rowData=new ArrayList<Object>();
				//获得本行中单元格的格数
				int cellCount=row.getLastCellNum();
				for(int j=0;j<cellCount;j++){
					HSSFCell cell=row.getCell(j);
					//获得指定单元格的数据
					Object cellData=this.getCellString(cell);
					rowData.add(cellData);
				}
				result.add(rowData);
			}
		}
		return result;
	}
	
	
	private Object getCellString(HSSFCell cell) {
		// TODO Auto-generated method stub
		Object result = null;
                DecimalFormat format=new DecimalFormat("#.###");
		if(cell != null){
		//单元格类型：Numeric:0,String:1,Formula:2,Blank:3,Boolean:4,Error:5
		int cellType = cell.getCellType();
		switch (cellType) {
		case HSSFCell.CELL_TYPE_STRING:
		result = cell.getRichStringCellValue().getString();
		break;
		case HSSFCell.CELL_TYPE_NUMERIC:
		result = format.format(cell.getNumericCellValue());
		break;
		case HSSFCell.CELL_TYPE_FORMULA:
		result = format.format(cell.getNumericCellValue());
		break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
		result = cell.getBooleanCellValue();
		break;
		case HSSFCell.CELL_TYPE_BLANK:
		result = null;
		break;
		case HSSFCell.CELL_TYPE_ERROR:
		result = null;
		break;
		default:
		System.out.println("枚举了所有类型");
		break;
		}
		}
		return result;
		}
}
