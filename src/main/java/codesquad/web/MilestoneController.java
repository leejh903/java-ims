package codesquad.web;

import codesquad.domain.milestone.MilestoneBody;
import codesquad.service.MilestoneService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@RequestMapping("/milestones")
public class MilestoneController {
    private static final Logger log = getLogger(MilestoneController.class);

    @Resource(name = "milestoneService")
    private MilestoneService milestoneService;

    @GetMapping("")
    public String list() {
        return "milestone/list";
    }

    @GetMapping("/form")
    public String form() {
        return "milestone/form";
    }

    @PostMapping("")
    public String create(@Valid MilestoneBody milestoneBody) {
        milestoneService.create(milestoneBody);
        return "redirect:/milestones";
    }
}
