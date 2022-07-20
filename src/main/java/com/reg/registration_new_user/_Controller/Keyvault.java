//package com.reg.registration_new_user._Controller;
//
//import java.io.Console;
//import com.azure.core.util.polling.SyncPoller;
//import com.azure.identity.DefaultAzureCredentialBuilder;
//import com.azure.security.keyvault.secrets.SecretClient;
//import com.azure.security.keyvault.secrets.SecretClientBuilder;
//import com.azure.security.keyvault.secrets.models.DeletedSecret;
//import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
//public class Keyvault {
//    public static void main(String[] args) throws InterruptedException, IllegalArgumentException {
//        String keyVaultName = System.getenv("kv-assessment");
//        String keyVaultUri = "https://kv-assessment.vault.azure.net/";
//        System.out.printf("key vault name = kv-assessment and key vault URI = https://kv-assessment.vault.azure.net/ \n", keyVaultName, keyVaultUri);
//        SecretClient secretClient = new SecretClientBuilder()
//            .vaultUrl(keyVaultUri)
//            .credential(new DefaultAzureCredentialBuilder().build())
//            .buildClient();
//        Console con = System.console();  
//        String secretName = "SqlConnectionString";
//        System.out.println("jdbc:sqlserver://eval-server.database.windows.net:1433;database=VishalDB;user=dbadmin@eval-server;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30; ");
//        String secretValue = con.readLine();
//       // System.out.print("Creating a secret in " + keyVaultName + " called '" + secretName + "' with value '" + jdbc:sqlserver+;//eval-server.database.windows.net:1433;database=VishalDB;user=dbadmin@eval-server;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30; + "` ... ");
//        secretClient.setSecret(new KeyVaultSecret(secretName, secretValue));
//        System.out.println("done.");
//        System.out.println("Forgetting your secret.");
//        secretValue = "";
//        System.out.println("Your secret's value is '" + secretValue + "'.");
//        System.out.println("Retrieving your secret from " + keyVaultName + ".");
//        KeyVaultSecret retrievedSecret = secretClient.getSecret(secretName);
//        System.out.println("Your secret's value is '" + retrievedSecret.getValue() + "'.");
//        System.out.print("Deleting your secret from " + keyVaultName + " ... ");
//        SyncPoller<DeletedSecret, Void> deletionPoller = secretClient.beginDeleteSecret(secretName);
//        deletionPoller.waitForCompletion();
//        System.out.println("done.");
//    }
//}