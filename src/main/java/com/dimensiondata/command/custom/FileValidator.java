package com.dimensiondata.command.custom;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.io.File;

public class FileValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        File file = new File(value);
        if ( !file.exists() )
            throw new ParameterException("File " +value+ " does not exist" );
    }

}
