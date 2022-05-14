package com.codelearnhub.springBeanAnnotationTutorial;

public class SomeApiClientFromALibrary {

    private String client_id;
    private String client_secret;
    private long timeout;

    public static class Builder {

        private String client_id;
        private String client_secret;
        private long timeout = 2000;

        public Builder() {
        }

        Builder(String client_id, String client_secret, long timeout) {
            this.client_id = client_id;
            this.client_secret = client_secret;
            this.timeout = timeout;
        }

        public Builder client_id(String client_id){
            this.client_id = client_id;
            return Builder.this;
        }

        public Builder client_secret(String client_secret){
            this.client_secret = client_secret;
            return Builder.this;
        }

        public Builder timeout(long timeout){
            this.timeout = timeout;
            return Builder.this;
        }


        public SomeApiClientFromALibrary build() {
            if(this.client_id == null){
                throw new NullPointerException("The property \"client_id\" is null.");
            }
            if(this.client_secret == null){
                throw new NullPointerException("The property \"client_secret\" is null.");
            }

            return new SomeApiClientFromALibrary(this);
        }
    }

    private SomeApiClientFromALibrary(Builder builder) {
        this.client_id = builder.client_id;
        this.client_secret = builder.client_secret;
        this.timeout = builder.timeout;
    }

    public void connectToAPI() {
        System.out.println("Connected Successfully");
    }

    public void closeAPIConnection() {
        System.out.println("Connection closed");
    }

}