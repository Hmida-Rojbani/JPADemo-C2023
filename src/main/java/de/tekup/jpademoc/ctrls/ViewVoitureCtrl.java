package de.tekup.jpademoc.ctrls;

import de.tekup.jpademoc.config.FileUploadUtil;
import de.tekup.jpademoc.entites.ClientEntity;
import de.tekup.jpademoc.entites.VoitureEntity;
import de.tekup.jpademoc.services.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/voitures/ui")
@AllArgsConstructor
public class ViewVoitureCtrl {
    private VoitureService voitureService;

//    @GetMapping("/")
//    public String diplayVoiture(Model model) {
//        model.addAttribute("cars",voitureService.getAllVoiture());
//        return "car";
//    }

    @GetMapping("/")
    public String dispalyByPage(Model model, @RequestParam("page")Optional<Integer> optPage,
                                @RequestParam("size")Optional<Integer> optSize){
        int page = optPage.orElse(1);
        int size = optSize.orElse(6);
        Page<VoitureEntity> voiturePage = voitureService.getByPage(PageRequest.of(page-1,size));
        model.addAttribute("voiturePage",voiturePage);
        int totalPage = voiturePage.getTotalPages();
        if(totalPage>0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        return "car";
    }

    @GetMapping("/add")
    public String addVoitures(Model model){
        model.addAttribute("voiture",new VoitureEntity());
        return "car-add";
    }

    @PostMapping("/add")
    public String addClientsPost(@Valid @ModelAttribute("voiture") VoitureEntity voiture,
                                 BindingResult result
                                , @RequestParam("fileImg")MultipartFile multipartFile){

        if (result.hasErrors()){
            return "car-add";
        }
        voitureService.addVoiture(voiture);
        if(!multipartFile.isEmpty()){
            String orgFileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            String ext = orgFileName.substring(orgFileName.lastIndexOf("."));
            String uploadDir = "voitures-photos/";
            String fileName = "voiture-"+voiture.getId()+ext;
            FileUploadUtil.saveFile(uploadDir,fileName,multipartFile);
            voiture.setImagePath("/"+uploadDir+fileName);
            voitureService.addVoiture(voiture);
        }

        return "redirect:/voitures/ui/";
    }
}
