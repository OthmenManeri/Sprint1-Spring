package com.othmen.meubles.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.othmen.meubles.entities.meuble;
import com.othmen.meubles.entities.type;
import com.othmen.meubles.service.meubleService;
import com.othmen.meubles.service.typeService;

@Controller
public class meubleController {
@Autowired
meubleService meubleService;
@Autowired
typeService typeService;
@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
List<type> types = typeService.findAll();
modelMap.addAttribute("type", types);
modelMap.addAttribute("meuble", new meuble());
modelMap.addAttribute("mode", "new");
return "formmeuble";
}
@RequestMapping("/savemeuble")
public String savemeuble(ModelMap modelMap,@Valid meuble meuble,
BindingResult bindingResult)
{
	List<type> types = typeService.findAll();
	modelMap.addAttribute("type", types);
System.out.println(meuble);
if (bindingResult.hasErrors()) return "formmeuble";
meubleService.savemeuble(meuble);
return "redirect:/Listemeubles";
}

@RequestMapping("/showCreatetype")
public String showCreatetype(ModelMap modelMap)
{
modelMap.addAttribute("type", new type());
modelMap.addAttribute("mode", "new");
return "formtype";
}
@RequestMapping("/savetype")
public String savetype(@ModelAttribute("type") type type,ModelMap modelMap) throws ParseException 
{
type savetype = typeService.savetype(type);
return "redirect:/Listetype";
}

@RequestMapping("/Listetype")
public String listemeubles(ModelMap modelMap)
{
List <type> types = typeService.findAll();
modelMap.addAttribute("type", types);
return "Listetype";
}

@RequestMapping("/Listemeubles")
public String listemeubles(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
	List<type> types = typeService.findAll();
	modelMap.addAttribute("type", types);
Page<meuble> prods = meubleService.getAllmeublesParPage(page, size);
modelMap.addAttribute("meubles", prods);
 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listemeubles";
}


@RequestMapping("/supprimermeuble")
public String supprimermeuble(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
meubleService.deletemeubleById(id);
Page<meuble> prods = meubleService.getAllmeublesParPage(page, 
size);
modelMap.addAttribute("meubles", prods);
modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listemeubles";
}
@RequestMapping("/supprimertype")
public String supprimertype(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
typeService.deletetypeById(id);
List<type> types = typeService.findAll();
modelMap.addAttribute("type", types);
return "Listetype";
}

@RequestMapping("/modifiermeuble")
public String editermeuble(@RequestParam("id") Long id,ModelMap modelMap)
{
meuble p= meubleService.getmeuble(id);
List<type> types = typeService.findAll();
types.remove(p.gettype());
modelMap.addAttribute("type", types);
modelMap.addAttribute("meuble", p);
modelMap.addAttribute("mode", "edit");
return "formmeuble";
}
@RequestMapping("/updatemeuble")
public String updatemeuble(@ModelAttribute("meuble") meuble meuble,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 
	 
	 meubleService.updatemeuble(meuble);
	 List<meuble> prods = meubleService.getAllmeubles();
	 modelMap.addAttribute("meubles", prods);
	return "listemeubles";
	}
@RequestMapping("/modifiertype")
public String editertype(@RequestParam("id") Long id,ModelMap modelMap)
{
type c= typeService.gettype(id);
modelMap.addAttribute("type", c);
modelMap.addAttribute("mode", "edit");
return "formtype";
}
@RequestMapping("/updatetype")
public String updatetype(@ModelAttribute("type") type type,ModelMap modelMap) throws ParseException {
	typeService.updatetype(type);
	 List<type> types = typeService.findAll();
	 modelMap.addAttribute("type", types);
	return "Listetype";
	}


@RequestMapping("/search")
public String recherNom(@RequestParam("nom") String nom,
ModelMap modelMap)
{
	List<type> types = typeService.findAll();
	modelMap.addAttribute("type", types);
List<meuble> prods = meubleService.findByNommeuble(nom);
modelMap.addAttribute("meubles",prods);
modelMap.addAttribute("mode", "SearchNomP");
return "listemeubles";
}
@RequestMapping("/searchtype")
public String rechertype(@RequestParam("type") Long type,ModelMap modelMap)
{
type types = new type();
types.setIdtype(type);
List<type> types2 = typeService.findAll();
modelMap.addAttribute("type", types2);
List<meuble> prods = meubleService.findBytype(types);
modelMap.addAttribute("meubles",prods);
modelMap.addAttribute("mode", "Searchtype");
return "listemeubles";
}
}