package com.othmen.produits;




import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.othmen.meubles.entities.type;
import com.othmen.meubles.entities.meuble;
import com.othmen.meubles.repos.meubleRepository;
import com.othmen.meubles.service.meubleService;
@SpringBootTest
class meublesApplitypeionTests {
@Autowired
private meubleRepository meubleRepository;

@Autowired
private meubleService meubleService;

@Test
public void testCreatemeuble() {
meuble prod = new meuble("PC Dell",2200.500,new Date());
meubleRepository.save(prod);
}
@Test
public void testFindmeuble()
{
meuble p = meubleRepository.findById(1L).get(); 
System.out.println(p);
}
@Test
public void testUpdatemeuble()
{
meuble p = meubleRepository.findById(1L).get();
p.setPrixmeuble(1000.0);
meubleRepository.save(p);
}
@Test
public void testDeletemeuble()
{
meubleRepository.deleteById(1L);;
}
 
@Test
public void testListerTousmeubles()
{
List<meuble> meub = meubleRepository.findAll();
for (meuble p : meub)
{
System.out.println(p);
}
}
@Test
public void testFindByNommeubleContains()
{
Page<meuble> meub = meubleService.getAllmeublesParPage(0,2);
System.out.println(meub.getSize());
System.out.println(meub.getTotalElements());
System.out.println(meub.getTotalPages());
meub.getContent().forEach(p -> {System.out.println(p.toString());
 });

}
@Test
public void testFindByNommeuble()
{
List<meuble> meub = meubleRepository.findByNommeuble("Clavier");
for (meuble p : meub)
{
System.out.println(p);
}
}
@Test
public void findByNommeubleContains()
{
List<meuble> meub=meubleRepository.findByNommeuble("P");
for (meuble p : meub)
{
System.out.println(p);
} }
@Test
public void testfindByNomPrix()
{
List<meuble> meub = meubleRepository.findByNomPrix("iphone X", 1000.0);
for (meuble p : meub)
{
System.out.println(p);
}
}

@Test
public void testfindBytype()
{
type type = new type();
type.setIdtype(1L);
List<meuble> meub = meubleRepository.findBytype(type);
for (meuble p : meub)
{
System.out.println(p);
}
}
@Test
public void findBytypeIdtype()
{
List<meuble> meub = meubleRepository.findBytypeIdtype(1L);
for (meuble p : meub)
{
System.out.println(p);
}
 }
@Test
public void testfindByOrderByNommeubleAsc()
{
List<meuble> meub = 
meubleRepository.findByOrderByNommeubleAsc();
for (meuble p : meub)
{
System.out.println(p);
}
}
@Test
public void testTriermeublesNomsPrix()
{
List<meuble> meub = meubleRepository.triermeublesNomsPrix();
for (meuble p : meub)
{
System.out.println(p);
}
}
}
