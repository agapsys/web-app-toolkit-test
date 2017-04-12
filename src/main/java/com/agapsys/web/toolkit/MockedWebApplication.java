/*
 * Copyright 2016 Agapsys Tecnologia Ltda-ME.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.agapsys.web.toolkit;

import com.agapsys.web.toolkit.services.LogService;
import com.agapsys.web.toolkit.utils.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.annotation.WebListener;

@WebListener
public class MockedWebApplication extends AbstractWebApplication {

    @Override
    public String getRootName() {
        return "test-app";
    }

    @Override
    public String getVersion() {
        return "0.1.0";
    }

    @Override
    protected File getParentDir() {
        try {
            return FileUtils.getRandomNonExistentFile(FileUtils.DEFAULT_TEMPORARY_FOLDER, 8, 1000);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void afterStop() {
        super.afterStop();
        
        try {
            FileUtils.deleteFile(getDirectory().getParentFile());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        
    }

    @Override
    protected void beforeStart() {
        super.beforeStart();
        
        LogService customLogService = new LogService();
        customLogService.addLogger(new LogService.ConsoleLogger());
        registerService(customLogService);
    }

}
