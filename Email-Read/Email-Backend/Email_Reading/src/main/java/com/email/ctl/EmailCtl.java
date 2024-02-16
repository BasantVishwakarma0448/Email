package com.email.ctl;

import com.email.Json.ResponseJSON;
import com.email.form.EmailForm;
import com.email.model.EmailModel;

import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/mail")
public class EmailCtl {

    EmailModel model = new EmailModel();

    @GetMapping(value = "/getInbox")
    public ResponseJSON getInboxes() {
        ResponseJSON res = new ResponseJSON();
        List<EmailForm> list = model.getList();
        res.addResult("list", list);
        return res;
    }
}
