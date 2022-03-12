package com.netease.test.trade.controller;

import com.netease.test.trade.entity.Commodity;
import com.netease.test.trade.entity.PurItem;
import com.netease.test.trade.service.CommodityService;
import com.netease.test.trade.service.PurItemService;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private PurItemService purItemService;

    @RequestMapping("/")
    public String welcome(HttpServletRequest request, @RequestParam(value="type", required = false, defaultValue = "0") int type){
        if(type==0){
            List<Commodity> allCommodity = commodityService.getAllCommodity();
            request.setAttribute("commoditys", allCommodity);
        }else if (type==1){
            List<Commodity> allCommodity = commodityService.getUnBuyCommodity();
            request.setAttribute("commoditys", allCommodity);
        }
        return "index";
    }

    @RequestMapping("/show")
    public String show(@RequestParam("id") String id, HttpServletRequest request){
        Commodity commodity = commodityService.getCommodityById(id);
        PurItem purItem = purItemService.getPurItemById(id);
        if(purItem!=null){
            request.setAttribute("buyPrice", purItem.getPrice());
        }else {
            request.setAttribute("buyPrice", null);
        }
        request.setAttribute("commodity", commodity);
        return "detail";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, HttpServletRequest request, @RequestParam(name = "file", required = false)MultipartFile file){
        Commodity commodity = commodityService.getCommodityById(id);
        request.setAttribute("commodity", commodity);
        return "edit";
    }

    @RequestMapping("/publicSubmit")
    public String publicSubmit(Commodity commodity){
        commodityService.insertCommodity(commodity);
        return "redirect:/";
    }

    @RequestMapping("/updateSubmit")
    public String updateSubmit(Commodity commodity){
        commodityService.updateCommodity(commodity);
        return "redirect:/show?id="+commodity.getId();
    }

    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam(name = "file", required = false)MultipartFile file){
        String filename = file.getOriginalFilename();
        String filePath = "./src/main/resources/static/image/"+filename;
        File dest = new File(new File(filePath).getAbsolutePath());
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
            System.out.println(dest.getAbsolutePath());
            file.transferTo(dest);
            String imageUrl = "/image/"+filename;
            System.out.println("上传成功");
            return imageUrl;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("失败");
            return "";
        }
    }


    @RequestMapping("/delete")
    public String deleteCommodity(@RequestParam("id") String id){
        commodityService.deleteCommodity(id);
        return "redirect:/";
    }






}
