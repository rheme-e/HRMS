package org.example.hrms.adapter.concretes;

import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;
import org.example.hrms.mernisReferance.DAVKPSPublicSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MernisAdapter implements org.example.hrms.adapter.abstracts.MernisAdapter {
    private DAVKPSPublicSoap davkpsPublicSoap;
    @Autowired
    public MernisAdapter(DAVKPSPublicSoap davkpsPublicSoap) {
        this.davkpsPublicSoap = davkpsPublicSoap;
    }

    @Override
    public boolean checkIfRealPerson(JobSeeker jobSeeker) throws Exception {
        return davkpsPublicSoap.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getTcNo()), jobSeeker.getName(), jobSeeker.getLastName(), jobSeeker.getBirthDayYear());
    }
}
