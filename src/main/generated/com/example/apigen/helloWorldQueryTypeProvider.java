package com.example.apigen;

import com.example.apigen.Page;
import java.util.List;
import com.distelli.graphql.MethodDataFetcher;
import com.distelli.graphql.ResolverDataFetcher;
import graphql.Scalars;
import graphql.schema.*;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Named;
import java.util.Optional;

@Named
public class helloWorldQueryTypeProvider implements Provider<GraphQLObjectType> {
    @Inject
    private Optional<helloWorldQuery> _impl;
    @Inject
    protected helloWorldQueryTypeProvider() {}
    @Override
    public GraphQLObjectType get() {
        return GraphQLObjectType.newObject()
            .name("helloWorldQuery")
            .field(GraphQLFieldDefinition.newFieldDefinition()
                .type(new GraphQLList(new GraphQLTypeReference("Page")))
                .name("page")
                .argument(Arrays.asList(
                    GraphQLArgument.newArgument()
                    .name("url")
                    .type(Scalars.GraphQLString)
                    .build()))
                .dataFetcher(new MethodDataFetcher(
                    "page",
                    helloWorldQuery.PageArgs.class,
                    _impl.orElse(null)))
                .build())
            .build();
    }
}
