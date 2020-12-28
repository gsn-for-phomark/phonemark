package com.gsn.util;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传的工具类
 * @author 
 *
 */
public class FileUploadUtil {

	private static final String IMAGEPATH="/PhoneMark_images/";
	private static final String CHARSET="UTF-8";
	
	
	public static <T> T parseRequest(HttpServletRequest request,Class<T> cls) throws Exception{
		
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> items=upload.parseRequest(request);
		T t=cls.newInstance();
		Method []methods=cls.getDeclaredMethods();
		//通过反射创建对象
		t=cls.newInstance();
		//循环属性，请求对象中的数据库参数名必须和javaBean对象属性名一致
		for(FileItem item:items){
			if(item.isFormField()){
				//获取表单元素的name值
				String name=item.getFieldName();
				//获取表单元素的value值
				String value=item.getString(CHARSET);
				for(Method m:methods){
					if(("set"+name).equalsIgnoreCase(m.getName())){
						String typeName = m.getParameterTypes()[0].getName();//获取set方法的形参数据类型
						//获取当前方法的形参数据类型 set 一个参数
						if("java.lang.Integer".equals(typeName)){
							m.invoke(t, Integer.parseInt(value));
						}else if("java.lang.Double".equals(typeName)){
							m.invoke(t, Double.parseDouble(value));
						}else if("java.lang.Float".equals(typeName)){
							m.invoke(t, Float.parseFloat(value));
						}else if("java.lang.String".equals(typeName)){
							m.invoke(t, value);
						}else if("java.lang.Long".equals(typeName)){
							m.invoke(t, Long.parseLong(value));
						}else {
							//后期拓展
						}
						break;//跳出该循环
					}
				}
				System.out.println(name+"="+value);
			}else{
				String fieldName=item.getFieldName();
				//获取文件名称
				String name=item.getName();
				//文件在服务器的那个位置
				String path=request.getServletContext().getRealPath("/");
				//文件重名问题
				UUID uuid=UUID.randomUUID();
				String fileName=uuid.toString()+""+name;
				//如果把图片存到项目的目录下 但是当我们重启服务器后，项目下的文件就会消失
				//服务器webapp下创建一个名为images的文件夹 ，就相当于一个文件项目
				//文件如何写入到指定位置 项目下
				//创建创建文件对象
				File file=new File(path,IMAGEPATH+fileName);
				//将文件写入到磁盘中
				item.write(file);
				//获取存储的文件路径 如何处理 存储到image_path
				String image_path=IMAGEPATH+fileName;
				for(Method m:methods){
					if(("set"+fieldName).equalsIgnoreCase(m.getName())){
						m.invoke(t, image_path);
					}
				}
			}
		}
		return t;
	}
	
}
