package com.othmen.meubles.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.othmen.meubles.entities.meuble;
import com.othmen.meubles.service.meubleService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class meubleRESTController {
@Autowired
meubleService meubleService;
@RequestMapping(method = RequestMethod.GET)
public List<meuble> getAllmeubles() {
return meubleService.getAllmeubles();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public meuble getmeubleById(@PathVariable("id") Long id) {
return meubleService.getmeuble(id);
 }
@RequestMapping(method = RequestMethod.POST)
public meuble createmeuble(@RequestBody meuble meuble) {
return meubleService.savemeuble(meuble);
}
@RequestMapping(method = RequestMethod.PUT)
public meuble updatemeuble(@RequestBody meuble meuble) {
return meubleService.updatemeuble(meuble);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deletemeuble(@PathVariable("id") Long id)
{
meubleService.deletemeubleById(id);
}
@RequestMapping(value="/prodstype/{idtype}",method = RequestMethod.GET)
public List<meuble> getmeublesBytypeId(@PathVariable("idtype") Long idtype) {
return meubleService.findBytypeIdtype(idtype);
}
}
